package viet.com.hello;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Car extends BaseObservable {
  public String model;
  public String maker;
  public int year;

  public Car(String model, String maker, int year) {
    this.model = model;
    this.maker = maker;
    this.year = year;
  }

  @Bindable
  public String getModel() {
    return model;
  }

  @Bindable
  public String getMaker() {
    return maker;
  }

  @Bindable
  public int getYear() {
    return year;
  }

  @Bindable
  public String getDisplayText() {
    return getYear() + " " + getModel() + " " + getMaker();
  }
}
