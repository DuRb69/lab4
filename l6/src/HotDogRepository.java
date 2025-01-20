package src;

import java.util.ArrayList;
import java.util.List;

public class HotDogRepository {
    private List<src.HotDog> hotDogs;

    public HotDogRepository() {
        this.hotDogs = new ArrayList<>();
    }

    public void addHotDog(src.HotDog hotDog) {
        hotDogs.add(hotDog);
    }

    public void removeHotDog(int index) {
        if (index >= 0 && index < hotDogs.size()) {
            hotDogs.remove(index);
        }
    }

    public List<src.HotDog> getAllHotDogs() {
        return new ArrayList<>(hotDogs);
    }

    public void setHotDogs(List<src.HotDog> hotDogs) {
        this.hotDogs = hotDogs;
    }
}
