class Product {
        String name;
        double price;
        String[] tags;

        Product(String name, double price, String[] tags) {
            this.name = name;
            this.price = price;
            this.tags = tags;
        }

        void printInfo() {
            System.out.println(name + " - " + price + " kr");
            System.out.print("Tags: ");

            for (String tag : tags) {
                System.out.print(tag + " ");
            }

            System.out.println();
            System.out.println();
        }

        boolean hasTag(String tag) {
            for (int i = 0; i < tags.length; i++) {
                if (tags[i].equals(tag)) {
                    return true;
                }
            }
            return false;
        }
    }

        void main() {
            Product p1 = new Product("Donuts", 20, new String[]{"food", "new"});
            Product p2 = new Product("Ketchup", 10, new String[]{"food", "sale"});
            Product p3 = new Product("Mayonaise", 15, new String[]{"food", "sale"});
            Product p4 = new Product("Hairdryer", 1000, new String[]{"electronics",  "sale"});
            Product p5 = new Product("Monitor", 1000, new String[]{"electronics",  "sale"});

            Product[] products = {p1, p2, p3, p4, p5};

            System.out.println("Produkter på tilbud:");
            for (int i = 0; i < products.length; i++) {
                if (products[i].hasTag("sale")) {
                    products[i].printInfo();
                }
            }
        }