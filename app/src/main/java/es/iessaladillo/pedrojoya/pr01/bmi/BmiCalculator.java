package es.iessaladillo.pedrojoya.pr01.bmi;

/**
 * Allow Bmi calculation and clasification
 */
public class BmiCalculator {

    /**
     * @param weightInKgs Weight of the person in kgs
     * @param heightInMeters Height of the person in meters
     * @return The body mass index (BMI)
     */
    public static float calculateBmi(float weightInKgs, float heightInMeters) {
        float result;

        result = (float) (weightInKgs/(Math.pow(heightInMeters, 2)));

        return result;
    }


    /**
     * @param bmi Body mass index to get clasification from
     * @return A BmiClasification enum with the clasification of BMI
     */
    public BmiClasification getBmiClasification(float bmi) {
        BmiClasification clasif = null;

        if (bmi <= 18.5) {
            clasif = BmiClasification.LOW_WEIGHT;
        } else if (bmi > 18.5 || bmi <= 24.9) {
            clasif = BmiClasification.NORMAL_WEIGHT;
        } else if (bmi >= 25 || bmi <= 29.9) {
            clasif = BmiClasification.OVERWWEIGHT;
        } else if (bmi >= 30 || bmi <= 34.9) {
            clasif = BmiClasification.OBESITY_GRADE_1;
        } else if (bmi >= 35 || bmi <= 39.9) {
            clasif = BmiClasification.OBESITY_GRADE_2;
        } else if (bmi >= 40) {
            clasif = BmiClasification.OBESITY_GRADE_3;
        }

        return clasif;
    }

    public enum BmiClasification {
        LOW_WEIGHT, NORMAL_WEIGHT, OVERWWEIGHT, OBESITY_GRADE_1, OBESITY_GRADE_2, OBESITY_GRADE_3
    }
}
