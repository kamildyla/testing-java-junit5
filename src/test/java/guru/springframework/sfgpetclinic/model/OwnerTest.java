package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "wrong firstName"),
                        () -> assertEquals("Buck", owner.getLastName(), "wrong LastName")
                ),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "wrong city"),
                        () -> assertEquals("1231231234", owner.getTelephone(), "wrong Telephone")
                )
        );

        assertThat(owner.getCity(), is("Key West"));
    }
}