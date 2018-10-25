import java.util.Random;

public class GameTests {
  private static boolean error = false;
  public static Random rand = new Random();

  public static boolean testSetNext() {
    GameNode testNode1 = new GameNode(rand);
    GameNode testNode2 = new GameNode(rand);
    testNode1.setNext(testNode2);
    if (testNode1.getNext().getNumber() != testNode2.getNumber()) {
      error = true;
    }
    GameNode testNode3 = new GameNode(rand);
    testNode2.setNext(testNode3);
    if (testNode2.getNext() != testNode3) {
      error = true;
    }
    return error;
  }

  public static boolean testApplyOperator() {
    GameNode testNode1 = new GameNode(rand);
    GameNode testNode2 = new GameNode(rand);
    testNode1.setNext(testNode2);
    int testNumber = testNode1.getNumber() + testNode2.getNumber();
    testNode1.applyOperator(GameOperator.getFromChar('+'));
    if (testNode1.getNumber() != testNumber) {
      error = true;

    }
    return error;
  }

  public static boolean testAddNode() {
    GameNode testNode3 = new GameNode(rand);
    GameNode testNode4 = new GameNode(rand);
    GameList testList = new GameList();
    testList.addNode(testNode3);
    testList.addNode(testNode4);

    if (!testList.contains(testNode3.getNumber()) || !testList.contains(testNode4.getNumber())) {
      error = true;

    }
    if (testNode3.getNext()!=testNode4) {
      error = true;
    }
    return error;
  }
  public static boolean testApplyOperatorToNumber() {
    GameNode testNode3 = new GameNode(rand);
    GameNode testNode4 = new GameNode(rand);
    GameList testList = new GameList();
    testList.addNode(testNode3);
    testList.addNode(testNode4);
    int testNumber = testNode3.getNumber()/testNode4.getNumber();
    testList.applyOperatorToNumber(testNode3.getNumber(), GameOperator.getFromChar('/'));
    if(testNode3.getNumber()!=testNumber) {
      error = true;
    } 
    return error;
  }

  public static void main(String[] args) {
    error = testSetNext();
    error = testApplyOperator();
    error = testAddNode();
    error= testApplyOperatorToNumber();
    System.out.println(error);

  }
}
