package io.codeforall.bootcamp.factories;


import io.codeforall.bootcamp.shootable.Target;
import io.codeforall.bootcamp.shootable.TargetType;
import io.codeforall.bootcamp.shootable.bonus.Elias;
import io.codeforall.bootcamp.shootable.enemies.Andreia;
import io.codeforall.bootcamp.shootable.enemies.Carolina;
import io.codeforall.bootcamp.shootable.enemies.Rolo;
import io.codeforall.bootcamp.shootable.pedestrians.Afonso;
import io.codeforall.bootcamp.shootable.pedestrians.Manel;
import io.codeforall.bootcamp.shootable.pedestrians.Otavio;
import io.codeforall.bootcamp.shootable.pedestrians.Tiago;


/**
 * A factory of different types of Targets (see TargetType.java)
 *
 * @return a new instantiated target
 */
public class TargetFactory {

    public static Target getNewTarget() {

        int random = (int) (Math.random() * TargetType.values().length);
        TargetType targetType = TargetType.values()[random];

        Target target = null;


        try {
            switch (targetType) {
                case ANDREIA:
                    target = new Andreia();
                    System.out.println("Created ANDREIA");
                    break;

                case CAROLINA:
                    target = new Carolina();
                    System.out.println("Created CAROLINA");
                    break;

                case ROLO:
                    target = new Rolo();
                    System.out.println("Created ROLO");
                    break;

                case AFONSO:
                    target = new Afonso();
                    System.out.println("Created AFONSO");
                    break;

                case MANEL:
                    target = new Manel();
                    System.out.println("Created MANEL");
                    break;

//                case OTAVIO:
//                    target = new Otavio();
//                    System.out.println("Created OTAVIO");
//                    break;

                case TIAGO:
                    target = new Tiago();
                    System.out.println("Created TIAGO");
                    break;

//                case ELIAS:
//                    target = new Elias();
//                    System.out.println("Created ELIAS");
//                    break;

                default:
                    target = new Rolo();
                    System.out.println("Created DEFAULT");
            }
        } catch (Exception e) {
            System.out.println("Failed to create target: " + targetType);
            e.printStackTrace();
        }
        return target;
    }
}
