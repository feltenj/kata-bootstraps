import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ApplicationSpec :
        StringSpec({
            "todo" { true shouldBe true }
        })
