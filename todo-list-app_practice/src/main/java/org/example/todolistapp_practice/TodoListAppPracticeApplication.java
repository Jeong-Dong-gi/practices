package org.example.todolistapp_practice;

import org.example.todolistapp_practice.event.*;
import org.example.todolistapp_practice.reader.EventCsvReader;
import org.example.todolistapp_practice.reader.RawCsvReader;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class TodoListAppPracticeApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader(new RawCsvReader());
        String meetingCsvPath = "/data/meeting.csv";
        String noDisturbanceCsvPath = "/data/no_disturbance.csv";
        String outOfOfficeCsvPath = "/data/out_of_office.csv";
        String toDoCsvPath = "/data/to_do.csv";

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);

        List<NoDisturbance> noDisturbances = csvReader.readNoDisturbance(noDisturbanceCsvPath);
        noDisturbances.forEach(schedule::add);

        List<OutOfOffice> outOfOffices = csvReader.readOutOfOffice(outOfOfficeCsvPath);
        outOfOffices.forEach(schedule::add);

        List<Todo> todos = csvReader.readTodo(toDoCsvPath);
        todos.forEach(schedule::add);

        schedule.printAll();
    }

}
