import java.util.Objects;

public class ItemChain extends Item{

    public ItemChain(int id, String title) {
        super(id, title);
    }

    @Override
    public int hashCode() {
        return getTitle().charAt(0);
    }
}
