import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.databinding.FragmentCreateReservationBinding
import com.google.android.material.textfield.TextInputLayout

class CreateReservationFragment : Fragment() {

    private var binding: FragmentCreateReservationBinding? = null
    private val createReservationBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateReservationBinding.inflate(inflater, container, false)
        return createReservationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fields = ReservationFields(
            createReservationBinding.firstNameCreateReservation,
            createReservationBinding.lastNameCreateReservation,
            createReservationBinding.checkinCreateReservation,
            createReservationBinding.checkoutCreateReservation,
            createReservationBinding.additionalNeedsCreateReservation,
            createReservationBinding.totalPriceCreateReservation
        )

        createReservationBinding.createReservationButton.setOnClickListener {
            validateFields(fields)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun validateFields(fields: ReservationFields) {
        validateTextInputLayout(fields.firstNameInput, "O campo Nome é obrigatório")
        validateTextInputLayout(fields.lastNameInput, "O campo Sobrenome é obrigatório")
        validateTextInputLayout(fields.checkinInput, "O campo Checkin é obrigatório")
        validateTextInputLayout(fields.checkoutInput, "O campo Checkout é obrigatório")
        validateTextInputLayout(
            fields.additionalNeedsInput,
            "O campo Necessidades Adicionais é obrigatório"
        )
        validateTextInputLayout(fields.totalPriceInput, "O campo Preço Total é obrigatório")
    }

    private fun validateTextInputLayout(inputLayout: TextInputLayout, errorMessage: String) {
        val text = inputLayout.editText?.text.toString().trim()
        if (text.isEmpty()) {
            inputLayout.error = errorMessage
        } else {
            inputLayout.error = null
        }
    }
}

data class ReservationFields(
    val firstNameInput: TextInputLayout,
    val lastNameInput: TextInputLayout,
    val checkinInput: TextInputLayout,
    val checkoutInput: TextInputLayout,
    val additionalNeedsInput: TextInputLayout,
    val totalPriceInput: TextInputLayout
)