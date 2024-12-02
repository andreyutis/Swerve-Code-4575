package frc.robot;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

@Configuration
@ComponentScan(basePackages = "frc.robot")
public class SpringConfig implements InitializingBean {

    @Bean
    public SendableChooser<Command> autoChooser() {
        SendableChooser<Command> autoChooser = AutoBuilder.buildAutoChooser();
        SmartDashboard.putData("Auto Chooser", autoChooser);
        return autoChooser;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring context is loaded");
    }

}
