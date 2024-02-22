package yaboichips.bettermovement.client;

public interface IPigMixin {
    default void setWinged(boolean bool){
    }
    default boolean isWinged(){
        return false;
    }
}
