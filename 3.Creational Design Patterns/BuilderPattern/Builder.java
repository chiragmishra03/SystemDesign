
class AmazonCart {
    // mandatory field
    private int quantity;
    private String size;

    // optional
    private boolean giftWrap;
    private String color;

    private AmazonCart(AmazonCartBuilder ab) {
        this.quantity = ab.quantity;
        this.size = ab.size;
        this.giftWrap = ab.giftWrap;
        this.color = ab.color;
    }

    @Override 
    public String toString() {
        return "color=" + color +
                ", quantity=" + quantity +
                ", size=" + size +
                ", giftWrap=" + giftWrap;
    }

    public static class AmazonCartBuilder {
        // mandatory field
        private int quantity;
        private String size;

        // optional
        private boolean giftWrap;
        private String color;

        AmazonCartBuilder(int quantity, String size) {
            this.size = size;
            this.quantity = quantity;
        }

        public AmazonCartBuilder withGiftWrap(boolean giftWrap) {
            this.giftWrap = giftWrap;
            return this;
        }

        public AmazonCartBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public AmazonCart build() {
            if (quantity <= 0) {
                throw new IllegalStateException("Quantity must be greater than 0");
            }
            if (size == null || size.isEmpty()) {
                throw new IllegalStateException("Size is mandatory");
            }
            return new AmazonCart(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        AmazonCart cart = new AmazonCart.AmazonCartBuilder(0, "M").withColor("Green").build();
        System.out.println(cart.toString());

        AmazonCart cart1 = new AmazonCart.AmazonCartBuilder(2, "XL").build();
        System.out.println(cart1.toString());
    }
}
