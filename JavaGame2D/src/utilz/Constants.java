package utilz;

import main.Game;

public class Constants {
    public static final float GRAVITY = 0.04f* Game.SCALE;
    public static final int ANI_SPEED = 25;

    public static class ObjectConstants{
        public static final int FAKE_SALT = 0;
        public static final int REAL_SALT = 1;
        public static final int FAKE_SALT_VALUE = 1;
        public static final int REAL_SALT_VALUE = 1;
        public static final int SALT_WIDTH_DEFAULT = 50;
        public static final int SALT_HEIGHT_DEFAULT = 50;
        public static final int SALT_WIDTH = (int)(Game.SCALE * SALT_WIDTH_DEFAULT);
        public static final int SALT_HEIGHT = (int)(Game.SCALE * SALT_HEIGHT_DEFAULT);
        public static int GetSpriteAmount(int object_type){
            switch (object_type){
                case REAL_SALT , FAKE_SALT:
                    return 1;
            }
            return 1;
        }
    }
    public static class EnemyConstants{
        public static final int CRABBY = 0;

        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int ATTACK = 2;
        public static final int HIT = 3;
        public static final int DEAD = 4;

        public static final int CRABBY_WIDTH_DEFAULT = 50;
        public static final int CRABBY_HEIGHT_DEFAULT = 50;
        public static final int CRABBY_WIDTH = (int)(CRABBY_WIDTH_DEFAULT*Game.SCALE);
        public static final int CRABBY_HEIGHT = (int)(CRABBY_HEIGHT_DEFAULT*Game.SCALE);

        public static final int CRABBY_DRAWOFFSET_X =(int)(26*Game.SCALE);
        public static final int CRABBY_DRAWOFFSET_Y =(int)(9*Game.SCALE);

        public static int GetSpriteAmount(int enemy_type, int enemy_state){
            switch (enemy_type){
                case CRABBY:
                    switch (enemy_state){
                        case IDLE:
                            return 4;
                        case RUNNING:
                            return 4;
                        case ATTACK:
                            return 2;
                        case HIT:
                            return 3;
                        case DEAD:
                            return 2;
                    }
            }
            return 0;
        }
        public static int GetMaxHealth(int enemy_type){
            switch (enemy_type) {
                case CRABBY:
                    return 10;
                default:
                    return 1;
            }
        }
        public static int GetEnemyDmg(int enemy_type){
            switch (enemy_type) {
                case CRABBY:
                    return 1;
                default:
                    return 1;
            }
        }
    }

    public static class UI{
        public static class Buttons{
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int)(B_WIDTH_DEFAULT* Game.SCALE);
            public static final int B_HEIGHT = (int)(B_HEIGHT_DEFAULT* Game.SCALE);
        }
        public static class URMButtons{
            public static final int URM_DEFAULT_SIZE = 56;
            public static final int URM_SIZE = (int)(URM_DEFAULT_SIZE * Game.SCALE);
        }
    }

    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants{
        public static final int RUNNING = 0;
        public static final int IDLE = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int DEAD = 7;

        public static int GetSpriteAmount(int player_action){

            switch(player_action){
                case DEAD:
                    return 1;
                case RUNNING:
                    return 5;
                case IDLE:
                    return 5;
                case HIT:
                    return 4;
                case JUMP:
                    return 3;
                case ATTACK_1:
                    return 2;
                case FALLING:
                default:
                    return 1;
            }
        }
    }
}
