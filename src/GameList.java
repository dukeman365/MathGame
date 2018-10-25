public class GameList {
  private GameNode list; // reference to the first GameNode in this list
  
  public String board;

  public GameList() {
    list = null;
  } // initializes list to start out empty

  public void addNode(GameNode newNode) {
    GameNode pointer = list;
    if (pointer == null) {
      list = newNode;
    } else {
      while (pointer.getNext() != null) {
        pointer = pointer.getNext();
      }
      if (pointer.getNext() == null) {
        pointer.setNext(newNode);
      }
    }
  }
  // adds the new node to the end of this list

  public boolean contains(int number) {
    GameNode pointer = list;
    boolean contains = false;
    
    while (pointer != null) {
      if (pointer.getNumber()==number) {
        contains = true;
        pointer=null;
      } else {
        pointer = pointer.getNext();
      }
    }
    return contains;

  }

  // only returns true when this list contains a node with the specified number
  public String toString() {
    GameNode pointer = list;
    board = "";
    while (pointer != null) {
      if (pointer.getNext() != null) {
        board = board + pointer.getNumber() + " -> ";
        pointer = pointer.getNext();
      } else {
        board = board + pointer.getNumber() + " -> END";
        pointer = null;
      }
    }
    return board;
  } // returns a string with each number in the list separated by " -> "s,
    // and ending with " -> END"

  public void applyOperatorToNumber(int number, GameOperator operator) {
    GameNode pointer = list;
    while (pointer!=null && pointer.getNext() != null&&pointer.getNumber()!=number) {
      pointer=pointer.getNext();
    }
    if(pointer.getNumber()==number) {
      pointer.applyOperator(operator);
    }

  }
}
