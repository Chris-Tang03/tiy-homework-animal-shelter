import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AnimalTest {

    @Test
    public void whenAnimalThenGiveItsProperties (){
        // Arrange
        Animal animal = new Animal("Nate", "Dragon", "", "Green");

        // Assert
        assertThat(animal.getName(), equalTo("Nate"));
        assertThat(animal.getSpecies(), equalTo("Dragon"));
        assertThat(animal.getBreed(), equalTo(""));
        assertThat(animal.getDescription(), equalTo("Green"));
    }
}
