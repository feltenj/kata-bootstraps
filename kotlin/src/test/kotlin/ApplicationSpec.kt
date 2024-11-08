import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class ApplicationSpec() :
    DescribeSpec({
        describe("Game of Life") {
            data class TestCase(
                val description: String,
                val livingNeighbours: LivingNeighbours,
                val expectedCellState: CellState,
                val currentCellState: CellState,
            ) : WithDataTestName {
                override fun dataTestName() = description

                constructor(
                    description: String,
                    livingNeighbours: LivingNeighbours,
                    expectedCellState: CellState,
                ) : this(description, livingNeighbours, expectedCellState, CellState.ALIVE)
            }

            withData(
                TestCase(
                    description = "underpopulation: a living cell with 0 living neighbours dies in the next generation",
                    livingNeighbours = LivingNeighbours(0),
                    expectedCellState = CellState.DEAD
                ),
                TestCase(
                    description = "underpopulation: a living cell with 1 living neighbours dies in the next generation",
                    livingNeighbours = LivingNeighbours(1),
                    expectedCellState = CellState.DEAD
                ),
                TestCase(
                    description = "survival: a living cell with 2 living neighbours survives to the next generation",
                    livingNeighbours = LivingNeighbours(2),
                    expectedCellState = CellState.ALIVE
                ),
                TestCase(
                    description = "survival: a living cell with 3 living neighbours survives to the next generation",
                    livingNeighbours = LivingNeighbours(3),
                    expectedCellState = CellState.ALIVE
                ),
                TestCase(
                    description = "overcrowding: a living cell with 4 living neighbours dies in the next generation",
                    livingNeighbours = LivingNeighbours(4),
                    expectedCellState = CellState.DEAD
                ),
                TestCase(
                    description = "staying dead: a dead cell with 2 living neighbours stays dead in the next generation",
                    livingNeighbours = LivingNeighbours(2),
                    expectedCellState = CellState.DEAD,
                    currentCellState = CellState.DEAD
                ),
            ) { (_, livingNeighbours, expectedCellState, currentCellState) ->
                val nextCellState = nextGeneration(currentCellState, livingNeighbours)

                nextCellState shouldBe expectedCellState
            }
        }
    })

fun nextGeneration(currentCellState: CellState, livingNeighbours: LivingNeighbours): CellState {
    if (livingNeighbours.value == 2 || livingNeighbours.value == 3) return currentCellState
    return CellState.DEAD
}

enum class CellState {
    ALIVE,
    DEAD
}

@JvmInline
value class LivingNeighbours(val value: Int)
