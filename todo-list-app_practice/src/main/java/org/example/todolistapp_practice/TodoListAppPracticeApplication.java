package org.example.todolistapp_practice;

import org.example.todolistapp_practice.event.Meeting;
import org.example.todolistapp_practice.event.Schedule;
import org.example.todolistapp_practice.reader.EventCsvReader;
import org.example.todolistapp_practice.update.UpdateMeeting;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class TodoListAppPracticeApplication {

    public static void main(String[] args) throws IOException {
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader();
        String meetingCsvPath = "/data/meeting.csv";

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);

        Meeting meeting = meetings.get(0);
        meeting.print();

        System.out.println("수정 후 ....");
        meeting.validateAndUpdate(
                new UpdateMeeting(
                        "new title",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "A",
                        "new agenda"
                )
        );

        meeting.delete(true);
        System.out.println("삭제 후 수정 시도 ....");
        meeting.validateAndUpdate(
                new UpdateMeeting(
                        "new title 2",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "B",
                        "new agenda 2"
                )
        );

        meeting.print();
    }

}
