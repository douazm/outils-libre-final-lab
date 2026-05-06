import org.fog.application.Application;
import org.fog.application.AppModule;
import org.fog.entities.FogDevice;
import org.fog.entities.Sensor;
import org.fog.entities.Actuator;
import org.fog.utils.TimeKeeper;
import org.cloudbus.cloudsim.core.CloudSim;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        try {
            // بدء المحاكاة
            CloudSim.init(1, Calendar.getInstance(), false);

            int userId = 0;
            String appId = "IoTApp";

            // إنشاء عقدة Fog (محلية)
            FogDevice fogNode = ExampleFogUtils.createFogDevice("FogNode", 1000, 1000, 10000, 10000, 100, 0.01, 100, 100);

            // إنشاء Sensor (حساس حرارة)
            Sensor tempSensor = new Sensor("TempSensor", "Temperature", userId, appId, new org.fog.utils.distribution.DeterministicDistribution(5));
            tempSensor.setGatewayDeviceId(fogNode.getId());
            tempSensor.setLatency(1.0);

            // إنشاء Actuator (مروحة)
            Actuator fan = new Actuator("Fan", userId, appId);
            fan.setGatewayDeviceId(fogNode.getId());
            fan.setLatency(1.0);

            // إنشاء تطبيق بسيط
            Application app = Application.createApplication(appId, userId);
            AppModule module = new AppModule(appId, "ProcessingModule", userId, 1000, 1000, 1000, 1000, 1000);
            app.addAppModule(module);

            // ربط Sensor → Module → Actuator
            app.addAppEdge("Temperature", "ProcessingModule", 1000, 1000, "TEMP", org.fog.application.AppEdge.SENSOR, 1);
            app.addAppEdge("ProcessingModule", "Fan", 1000, 1000, "ACTUATE", org.fog.application.AppEdge.ACTUATOR, 1);

            // تشغيل المحاكاة
            CloudSim.startSimulation();
            CloudSim.stopSimulation();

            System.out.println("Simulation finished successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
