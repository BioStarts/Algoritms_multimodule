import java.util.Objects;

public class Item {

    private final String Title;
    private final int Id;

    public String getTitle() {
        return Title;
    }

    public int getId() {
        return Id;
    }

    public Item(int id, String title) {
        Title = title;
        Id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(Title, item.Title) &&
                Objects.equals(Id, item.Id);
    }

    @Override
    public int hashCode() {
        return Id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Title='" + Title + '\'' +
                ", Id=" + Id +
                '}';
    }
}
