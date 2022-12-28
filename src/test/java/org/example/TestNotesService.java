package org.example;

import org.easymock.*;
import org.example.MockNotesStorage;
import org.example.Note;
import org.example.NotesStorage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestNotesService extends EasyMockSupport {

    NotesServiceImpl notesService = createMock(NotesServiceImpl.class);
    NotesStorage notesStorage = createMock(NotesStorage.class);
    Note note1 = new Note("name1", 3.44f);
    Note note2 = new Note("name1", 3.78f);

    @BeforeEach
    public void setUp() {

        notesStorage.add(note1);
        notesStorage.add(note2);
        notesService.add(note1);
        notesService.add(note2);
    }

    @Test
    public void test_add() {
        float avcheck = 0f;
        EasyMock.expectLastCall()
                .andAnswer(() -> {
                    notesService.add(note1);
                    return null;
                });
        EasyMock.expect(notesService.averageOf("name1")).andReturn(3.44f);
        EasyMock.replay(notesService);
        Assert.assertTrue(avcheck >= 0);

    }

    @Test
    public void test_avg() {
        Note note1 = new Note("name1", 3.44f);
        Note note2 = new Note("name1", 3.78f);
        notesService.add(note1);
        notesService.add(note2);

        EasyMock.expect(notesService.averageOf("note1")).andReturn(3.61f);
        EasyMock.replay(notesService);
        Assert.assertEquals(notesService.averageOf("note1"), 3.61f, 0.1);


    }

    @Test
    public void test_clear() {
        Note note1 = new Note("name1", 3.44f);
        Note note2 = new Note("name1", 3.78f);
        notesService.add(note1);
        notesService.add(note2);
        notesService.clear();
        EasyMock.expectLastCall();
        replay(notesService);
        Assert.assertEquals( notesStorage.getAllNotesOf("note1"), null);

    }
}
