import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class ApplicationSpec() :
    DescribeSpec({
        describe("Game of Life") {
                    data class TestCase (
                        val description: String,
                        val livingNeighbours: LivingNeighbours,
                        val expectedCellState: CellState
                    ): WithDataTestName {
                        override fun dataTestName(): String {
                            return description
                        }
                    }

                withData(
                    TestCase("a living cell with 0 living neighbours dies in the next generation", LivingNeighbours(0), CellState.DEAD),                    ,
                    TestCase("a living cell with 1 living neighbours dies in the next generation", LivingNeighbours(1), CellState.DEAD),
                    TestCase("a living cell with 2 living neighbours survives to the next generation", LivingNeighbours(2), CellState.ALIVE),
                ) { (desc, livingNeighbours, expectedCellState) ->
                    val currentCellState = CellState.ALIVE

                    val nextCellState = nextGeneration(currentCellState, livingNeighbours)

                    nextCellState shouldBe expectedCellState
                }

            it("a living cell with 2 living neighbours survives in the next generation") {
                val livingNeighbours = LivingNeighbours(2)
                val currentCellState = CellState.ALIVE

                val nextCellState = nextGeneration(currentCellState, livingNeighbours)

                nextCellState shouldBe CellState.ALIVE
            }
        }
    })

fun nextGeneration(currentCellState: CellState, livingNeighbours: LivingNeighbours): CellState {
    if (livingNeighbours.value == 2) return CellState.ALIVE
    return CellState.DEAD
}

enum class CellState {
    ALIVE,
    DEAD
}

@JvmInline
value class LivingNeighbours(val value: Int)
