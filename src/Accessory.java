public interface Accessory {
      String getName() ;
      String getEffectType();
      int gerEffectvalue() ;


}
abstract class BaseAccessory implements Accessory{
      String name;
      String EffectType;
      int effactValue;

      BaseAccessory(String name , String EffectType , int effactValue){
            this.name = name ;
            this.EffectType = EffectType;
            this.effactValue = effactValue;
      }
      public String getName() {
            return null;
      }

      public String getEffectType() {
            return null;
      }

      public int gerEffectvalue() {
            return 0;
      }
}
      class Amulet extends BaseAccessory{

            Amulet(String name, String EffectType, int effactValue) {
                  super(name, EffectType, effactValue);
            }

      }
      class Ring extends BaseAccessory{

            Ring(String name, String EffectType, int effactValue) {
                  super(name, EffectType, effactValue);
            }
      }
      class Earring extends BaseAccessory{

            Earring(String name, String EffectType, int effactValue) {
                  super(name, EffectType, effactValue);
            }
      }