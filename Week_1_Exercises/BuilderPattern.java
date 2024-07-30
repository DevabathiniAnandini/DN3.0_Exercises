
 class Computer {
  
    private String CPU;
    private int RAM;
    private int storage;
    private String GPU;
    private String motherboard;
    private String powerSupply;
    private String coolingSystem;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.motherboard = builder.motherboard;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
    }

    
    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public String getGPU() {
        return GPU;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public String getCoolingSystem() {
        return coolingSystem;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, storage=" + storage + "GB, GPU=" + GPU +
               ", motherboard=" + motherboard + ", powerSupply=" + powerSupply + ", coolingSystem=" + coolingSystem + "]";
    }

    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private String GPU;
        private String motherboard;
        private String powerSupply;
        private String coolingSystem;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args) {
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM(32)
                .setStorage(1000)
                .setGPU("NVIDIA RTX 3080")
                .setMotherboard("ASUS ROG STRIX")
                .setPowerSupply("750W")
                .setCoolingSystem("Liquid Cooling")
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM(16)
                .setStorage(500)
                .setGPU("Integrated")
                .setMotherboard("ASUS Prime")
                .setPowerSupply("500W")
                .setCoolingSystem("Air Cooling")
                .build();

        System.out.println("Gaming Computer: " + gamingComputer);
        System.out.println("Office Computer: " + officeComputer);
    }
}

