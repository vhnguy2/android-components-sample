package viet.com.hello;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {
  private MutableLiveData<List<Car>> cars;

  public LiveData<List<Car>> getCars() {
    if (cars == null) {
      cars = new MutableLiveData<>();
      loadCars();
    }

    return cars;
  }

  private void loadCars() {
    // asychronously load the cars
    Runnable r = new Runnable() {
      @Override
      public void run() {
        List<Car> myCars = new ArrayList<>();
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));
        myCars.add(new Car("Ford", "Taurus", 1993));
        myCars.add(new Car("Nissan", "Maxima", 1996));
        myCars.add(new Car("Ford", "Explorer", 1994));
        myCars.add(new Car("Honda", "Accord", 2009));

        cars.postValue(myCars);
      }
    };

    Handler handler = new Handler();
    handler.postDelayed(r, 3000);
  }
}
