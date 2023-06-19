import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskMatchesWhenMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskMatchesWhenNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);
    }
    @Test
    public void testMeetingMatchesReturnsTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1,"Май","Новый", "19.05.2023");

        boolean actual = meeting.matches("Май");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testMeetingMatchesReturnsTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1,"Май","Новый", "19.05.2023");

        boolean actual = meeting.matches("Новый");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testMeetingMatchesReturnsTrueWhenQueryInNotTopic() {
        Meeting meeting = new Meeting(1,"Май","Новый", "19.05.2023");

        boolean actual = meeting.matches("Написать");

        Assertions.assertFalse(actual);
    }
    @Test
    public void testEpicMatchesWhenNotMatches() {
        Epic epic = new Epic(5, new String[]{"Subtask 1"});

        boolean actual = epic.matches("Subtask 4");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatchesWhenMatches() {
        Epic epic = new Epic(5, new String[]{"Subtask 1"});

        boolean actual = epic.matches("Subtask 1");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

}