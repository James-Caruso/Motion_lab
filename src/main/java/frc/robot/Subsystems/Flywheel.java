package frc.robot.Subsystems;

import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase {
    private final SparkFlex motor;
    private final SparkAbsoluteEncoder encoder;
    private final PIDController controller = new PIDController(0, 0, 0);

    public Flywheel(int motorId) {
        motor = new SparkFlex(motorId, MotorType.kBrushless);
        encoder = motor.getAbsoluteEncoder();

        controller.setTolerance(0.025);
    }
    public Command turnFlywheel(){
        return runEnd(() -> motor.set(0.1), () -> motor.set(0)).withName("turnFlywheel");
    }
    // public void driveAngleTo(double setpoint) {
    //     motor.set(-MathUtil.clamp(angLimiter.calculate(controller.calculate(encoder.getPosition(), setpoint)), -1, 1));
    // }

    // public boolean isAtSetpoint() {
    //     return controller.atSetpoint();
    // }

    // public Command driveAngleToCommand(double setpoint) {
    //     return run(() -> driveAngleTo(setpoint)).finallyDo(() -> motor.set(0));
    // }

    // public Command manualOut() {
    //     return runEnd(() -> motor.set(0.2), () -> motor.set(-0.04)).withName("manaulOut");
    // }

    // public Command manualIn() {
    //     return runEnd(() -> motor.set(-0.2), () -> motor.set(-0.04)).withName("manualIn");
    // }

    // public void stop() {
    //     motor.set(0);
    // }
}
