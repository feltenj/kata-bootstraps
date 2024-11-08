import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class ApplicationSpec :
    DescribeSpec({
        describe("Game of Life") {
            describe("a living cell with 0 living neighbours dies in the next generation") {
                withData(LivingNeighbours(0), LivingNeighbours(1)) { livingNeighbours ->
                    val currentCellState = CellState.ALIVE

                    val nextCellState = nextGeneration(currentCellState, livingNeighbours)

                    nextCellState shouldBe CellState.DEAD
                }
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
