import java.util.ArrayList;
import java.io.Console;

public class HelpDesk{
  private static int TICKET = 1;
  private static final PriorityQueue<Ticket> DATA = new ArrayPriorityQueue<>();
  private static final ArrayList<Ticket> SOLVED = new ArrayList<>();
  private static final Console CONSOLE = System.console();

  private static String getString(String prompt) {
    return CONSOLE.readLine(prompt);
  }

  private static int getInt(String prompt) {
    int ret = 0;
    while ( true ) {
      try {
        ret = Integer.parseInt(getString(prompt));
        break;
      } catch ( NumberFormatException e ) {
        System.out.println("That's not a number.");
      }
    }

    return ret;
  }


  private void submitTicket() {
    System.out.println("\nSubmitting a ticket.");
    DATA.add(new Ticket( getString("Name: "), getInt("Priority: "),
          getString("Problem: "), TICKET));
    System.out.println("Your ticket number is " + TICKET++ + ".\n");
    return;
  }

  private void respondTicket() {
    if(DATA.isEmpty()){
      System.out.println("There are no tickets currently. Check back later.\n");
      return;
    }

    Ticket currentTicket = DATA.peekMin();

    while (true) {
      System.out.println(currentTicket);
      System.out.println(
          "1. Answer the ticket.\n" +
          "2. Close the ticket.\n" +
          "3. Adjust the priority.\n" +
          "4. Discard the ticket.\n");

      switch( getInt("> ") ) {
        case 1:
          currentTicket.setSolution(getString("Describe the solution: "));
          if ( currentTicket.getStatus() == 0 ) { 
            currentTicket.setStatus(1);
          }
          System.out.println("Solution recorded.\n");
          break;
        case 2:
          if ( currentTicket.getStatus() == 1 ) {
            currentTicket.setStatus(3);
          } else {
            currentTicket.setStatus(2);
          }
          SOLVED.add(DATA.removeMin());
          System.out.println("Ticket closed.\n");
          return;
        case 3:
          currentTicket.setPriority(getInt("New priority: "));
          DATA.add(DATA.removeMin());
          System.out.println("Priority adjusted.\n");
          return;
        case 4:
          DATA.removeMin();
          System.out.println("Ticket discarded.\n");
          return;
      }
    }
  }

  public void viewArchive() {
    if ( SOLVED.isEmpty() ) {
      System.out.println("There are no tickets in the archive.\n");
      return;
    }

    for ( Ticket t : SOLVED ) {
      System.out.println(t);
    }
  }

  public static void main(String[] args){
    HelpDesk hd = new HelpDesk();

    while(true){
      System.out.println(
          "1. Submit a ticket.\n" +
          "2. Respond to a ticket.\n" +
          "3. Look at the resolved tickets archive.\n" +
          "4. Exit.\n");
      switch ( getInt("> ") ) {
        case 1: hd.submitTicket(); break;
        case 2: hd.respondTicket(); break;
        case 3: hd.viewArchive(); break;
        case 4: System.exit(0); break;
      }
    }
  }
}

