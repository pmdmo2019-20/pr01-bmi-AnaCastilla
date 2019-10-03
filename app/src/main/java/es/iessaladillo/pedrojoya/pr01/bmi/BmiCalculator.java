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
    public float calculateBmi(float weightInKgs, float heightInMeters) {
        float result;

        if (weightInKgs <= 0) {
            throw new IllegalArgumentException("Weight cannot be negative neither 0");
        } else if (heightInMeters <= 0) {
            throw new IllegalArgumentException("Height cannot be negative neither 0");
        } else {
            result = weightInKgs/(heightInMeters*2);
        }

        return result;
    }


    /**
     * @param bmi Body mass index to get clasification from
     * @return A BmiClasification enum with the clasification of BMI
     */
    public BmiClasification getBmiClasification(float bmi) {

        if (bmi < 18.5f) {
            return BmiClasification.LOW_WEIGHT;
        } else if (bmi >= 18.5f && bmi <= 24.99f) {
            return BmiClasification.NORMAL_WEIGHT;
        } else if (bmi >= 25f && bmi <= 29.99f) {
            return BmiClasification.OVERWWEIGHT;
        } else if (bmi >= 30f && bmi <= 34.99f) {
            return BmiClasification.OBESITY_GRADE_1;
        } else if (bmi >= 35f && bmi <= 39.99f) {
            return BmiClasification.OBESITY_GRADE_2;
        } else if (bmi >= 40f) {
            return BmiClasification.OBESITY_GRADE_3;
        }

        return null;
    }

    public enum BmiClasification {
        LOW_WEIGHT, NORMAL_WEIGHT, OVERWWEIGHT, OBESITY_GRADE_1, OBESITY_GRADE_2, OBESITY_GRADE_3
    }
}
