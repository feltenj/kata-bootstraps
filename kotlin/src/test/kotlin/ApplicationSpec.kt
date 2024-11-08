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
                        override fun dataTestName() = description
                    }

      withData(
        TestCase(
          "underpopulation: a living cell with 0 living neighbours dies in the next generation",
          LivingNeighbours(0),
          CellState.DEAD
        ),
        TestCase(
          "underpopulation: a living cell with 1 living neighbours dies in the next generation",
          LivingNeighbours(1),
          CellState.DEAD
        ),
        TestCase(
          "survival: a living cell with 2 living neighbours survives to the next generation",
          LivingNeighbours(2),
          CellState.ALIVE
        ),
        TestCase(
          "survival: a living cell with 3 living neighbours survives to the next generation",
          LivingNeighbours(3),
          CellState.ALIVE
        ),
        TestCase(
          "overcrowding: a living cell with 4 living neighbours dies in the next generation",
          LivingNeighbours(4),
          CellState.DEAD
        )
      ) { (_, livingNeighbours, expectedCellState) ->
        val currentCellState = CellState.ALIVE

        val nextCellState = nextGeneration(currentCellState, livingNeighbours)

        nextCellState shouldBe expectedCellState
      }
    }
  })

fun nextGeneration(currentCellState: CellState, livingNeighbours: LivingNeighbours): CellState {
  if (livingNeighbours.value == 2 || livingNeighbours.value == 3) return CellState.ALIVE
  return CellState.DEAD
}

enum class CellState {
  ALIVE,
  DEAD
}

@JvmInline
value class LivingNeighbours(val value: Int)
