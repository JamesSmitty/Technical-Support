# technical-support pd3: James Smith, Jerry Lin, Niko Cruz-Marstead

We used `java.io.Console` to obtain input from the user. This allows us to
easily have some text prompting for input and deals with null input better than
other methods.

When the program is run, the user is asked for choices, in which they can
respond with either integers or strings, depending on the situation. When the
program is run, users can submit tickets, respond to tickets, and look at the
resolved tickets archive (which is initially empty). The cleanest way to check a
variable against multiple cases is the [switch][1] statement.

## Submitting Tickets

When submitting a ticket, the user is prompted for their name, the priority of
the issue, and the issue itself. These are saved in a `Ticket` which is added to
the queue.

## Responding to Tickets

When answering a ticket, the user can change the solution field of the `Ticket`,
close the ticket, adjust the priority, and discard the Ticket. When a ticket is
closed, it is removed from the queue and added to a database of solved tickets,
which can be referenced from the main menu.

If the priority of a ticket is changed, it is removed from the queue and added
again, which automatically moves it to the proper position in line based on its
priority.

A discarded ticket is permanently lost and eventually garbage collected.

[1]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
