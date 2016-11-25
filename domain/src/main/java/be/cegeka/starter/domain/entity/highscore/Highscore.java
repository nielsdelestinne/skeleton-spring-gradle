package be.cegeka.starter.domain.entity.highscore;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Highscore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private float highscore;

    @Embedded
    @NotNull(message = "User should not be empty")
    @Valid
    private User user;

    private Highscore() {
        // hibernate
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHighscore(float highscore) {
        this.highscore = highscore;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public float getHighscore() {
        return highscore;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return String.format(
                "Highscore[id=%d, firstName='%s', lastName='%s', email='%s', highscore='%f']",
                id,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                highscore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Highscore highscore1 = (Highscore) o;
        return id == highscore1.id &&
                Float.compare(highscore1.highscore, highscore) == 0 &&
                Objects.equals(user, highscore1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, highscore, user);
    }

    public static class HighscoreBuilder {

        private long id;
        private float highscore;
        private User user;

        private HighscoreBuilder(){}

        public static HighscoreBuilder highscore() {
            return new HighscoreBuilder();
        }

        public Highscore build() {
            Highscore highscore = new Highscore();
            highscore.setId(this.id);
            highscore.setHighscore(this.highscore);
            highscore.setUser(this.user);
            return highscore;
        }

        public HighscoreBuilder withHighscore(float highscore) {
            this.highscore = highscore;
            return this;
        }

        public HighscoreBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public HighscoreBuilder withId(long id) {
            this.id = id;
            return this;
        }
    }
}
