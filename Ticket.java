public class Ticket implements Comparable<Ticket> {
  private       int    status    = 0;
  private       int    priority;
  private       String name;
  private final int    id;
  private       String problem;
  private       String solution;

  public Ticket(String name, int priority, String problem, int id) {
    this.name = name;
    this.problem = problem;
    this.priority = priority;
    this.id = id;
  }

  int getPriority(){
    return priority;
  }

  int getStatus() {
    return status;
  }

  /**
   * Change the status of a ticket.
   * 0-open
   * 1-solved
   * 2-closed
   * 3-solved and closed
   */
  void setStatus(int newStatus) {
    status = newStatus;
  }

  /**
   * Change the priority of a ticket.
   */
  void setPriority(int newPriority) {
    priority = newPriority;
  }

  void setSolution(String newSolution) {
    solution = newSolution;
  }

  @Override
  public int compareTo(Ticket other) {
    return priority - other.getPriority();
  }

  @Override
  public String toString(){
    String retStr = "Ticket Number: " + id + "\n";
    retStr += "Priority: " + priority + "\n";
    retStr += "Name: " + name + "\n";
    retStr += "Problem: " + problem + "\n";
    retStr += "Status: " + status + "\n";
    retStr += "Solution: " + solution + "\n";
    return retStr;
  }
}

