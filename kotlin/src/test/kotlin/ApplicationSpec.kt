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
                val currentCellState: CellState,
                val expectedCellState: CellState,
            ) : WithDataTestName {
                override fun dataTestName() = description
            }

            withData(
                TestCase(
                    description = "underpopulation: a living cell with 0 living neighbours dies in the next generation",
                    livingNeighbours = LivingNeighbours(0),
                    currentCellState = CellState.ALIVE,
                    expectedCellState = CellState.DEAD,
                ),
                TestCase(
                    description = "underpopulation: a living cell with 1 living neighbours dies in the next generation",
                    livingNeighbours = LivingNeighbours(1),
                    currentCellState = CellState.ALIVE,
                    expectedCellState = CellState.DEAD,
                ),
                TestCase(
                    description = "survival: a living cell with 2 living neighbours survives to the next generation",
                    livingNeighbours = LivingNeighbours(2),
                    currentCellState = CellState.ALIVE,
                    expectedCellState = CellState.ALIVE,
                ),
                TestCase(
                    description = "survival: a living cell with 3 living neighbours survives to the next generation",
                    livingNeighbours = LivingNeighbours(3),
                    currentCellState = CellState.ALIVE,
                    expectedCellState = CellState.ALIVE,
                ),
                TestCase(
                    description = "overcrowding: a living cell with 4 living neighbours dies in the next generation",
                    livingNeighbours = LivingNeighbours(4),
                    currentCellState = CellState.ALIVE,
                    expectedCellState = CellState.DEAD,
                ),
                TestCase(
                    description = "staying dead: a dead cell with 2 living neighbours stays dead in the next generation",
                    livingNeighbours = LivingNeighbours(2),
                    currentCellState = CellState.DEAD,
                    expectedCellState = CellState.DEAD
                ),
                TestCase(
                    description = "reproduction: a dead cell with 3 living neighbours comes to life in the next generation",
                    livingNeighbours = LivingNeighbours(3),
                    currentCellState = CellState.DEAD,
                    expectedCellState = CellState.ALIVE
                ),
            ) { (_, livingNeighbours, currentCellState, expectedCellState) ->
                val nextCellState = nextGeneration(currentCellState, livingNeighbours)

                nextCellState shouldBe expectedCellState
            }
        }
    })

fun nextGeneration(currentCellState: CellState, livingNeighbours: LivingNeighbours) =
    when (livingNeighbours.value) {
        3 -> CellState.ALIVE
        2 -> currentCellState
        else -> CellState.DEAD
    }

enum class CellState {
    ALIVE,
    DEAD
}

@JvmInline
value class LivingNeighbours(val value: Int)
