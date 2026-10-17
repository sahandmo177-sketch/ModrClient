package gg.modr.schematic;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public final class ModrScreen extends Screen {
    private String status = "Ready — choose a module";
    private boolean materialHud;
    private boolean ghostPreview;
    private boolean placementHelper;
    private boolean maceTraining;
    private boolean fastPlaceTest;

    public ModrScreen() {
        super(Text.literal("Modr Client"));
    }

    @Override
    protected void init() {
        int left = this.width / 2 - 110;
        int top = this.height / 2 - 105;
        int w = 220;
        int h = 20;
        int gap = 25;

        addDrawableChild(moduleButton("Ghost Block Preview", left, top, w, h,
                () -> ghostPreview, () -> ghostPreview = !ghostPreview));
        addDrawableChild(moduleButton("Material HUD", left, top + gap, w, h,
                () -> materialHud, () -> materialHud = !materialHud));
        addDrawableChild(moduleButton("Placement Helper", left, top + gap * 2, w, h,
                () -> placementHelper, () -> placementHelper = !placementHelper));
        addDrawableChild(moduleButton("Fast Place (test worlds)", left, top + gap * 3, w, h,
                () -> fastPlaceTest, () -> fastPlaceTest = !fastPlaceTest));
        addDrawableChild(moduleButton("Mace Training HUD", left, top + gap * 4, w, h,
                () -> maceTraining, () -> maceTraining = !maceTraining));

        addDrawableChild(ButtonWidget.builder(Text.literal("Close"), b -> close())
                .dimensions(left, top + gap * 5, w, h).build());
    }

    private ButtonWidget moduleButton(String name, int x, int y, int width, int height,
                                      java.util.function.BooleanSupplier state, Runnable toggle) {
        return ButtonWidget.builder(buttonText(name, state), button -> {
            toggle.run();
            status = name + " " + (state.getAsBoolean() ? "ON" : "OFF")
                    + " (prototype toggle only)";
            clearAndInit();
        }).dimensions(x, y, width, height).build();
    }

    private Text buttonText(String name, java.util.function.BooleanSupplier state) {
        return Text.literal(name + ": " + (state.getAsBoolean() ? "ON" : "OFF"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, "MODR CLIENT", this.width / 2,
                this.height / 2 - 135, 0xFF55FFFF);
        context.drawCenteredTextWithShadow(this.textRenderer, status, this.width / 2,
                this.height / 2 + 65, 0xFFFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
