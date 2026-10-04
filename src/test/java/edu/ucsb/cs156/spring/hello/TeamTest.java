package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test 
    public void to_String_returns_correct_string(){
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_results_true_for_same_object(){
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_if_null(){
        assertEquals(false, team.equals(null));
    }

    @Test
    public void equals_returns_false_different_object(){
        Team team1 = new Team();
        assertEquals(false, team.equals(team1));
    }

    @Test 
    public void equals_true_for_name_and_members(){
        Team team1 = new Team("test-team");
        team1.addMember("Alice");
        team1.addMember("Bob");
        team.addMember("Alice");
        team.addMember("Bob");
        assertEquals(true, team.name.equals(team1.name) && team.members.equals(team1.members));
    }
    @Test 
    public void equals_false_for_name_and_true_members(){
        Team team1 = new Team("new-team");
        team1.addMember("Alice");
        team1.addMember("Bob");
        team.addMember("Alice");
        team.addMember("Bob");
        assertEquals(false, team.name.equals(team1.name) && team.members.equals(team1.members));
    }

    @Test 
    public void equals_true_for_name_and_false_members(){
        Team team1 = new Team("test-team");
        team1.addMember("Alice");
        team1.addMember("Bob");
        assertEquals(false, team.name.equals(team1.name) && team.members.equals(team1.members));
    }

    @Test 
    public void equals_false_for_name_and_false_members(){
        Team team1 = new Team("new-team");
        team1.addMember("Alice");
        team1.addMember("Bob");
        assertEquals(false, team.name.equals(team1.name) && team.members.equals(team1.members));
    }

    @Test 
    public void test_for_hashCode(){
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
