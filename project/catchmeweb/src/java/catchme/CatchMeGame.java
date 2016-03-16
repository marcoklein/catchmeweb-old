package catchme;

import catchme.render.HtmlRenderer;
import game.Game;
import game.Renderer;
import game.Simulator;
import game.World;
import java.util.logging.Logger;

/**
 *
 * @author Marco Klein
 */
public class CatchMeGame extends Game implements Renderer {
    private static final Logger LOG = Logger.getLogger(CatchMeGame.class.getName());
    
    protected HtmlRenderer renderer;
    protected HtmlBuilder renderedHtml;

    @Override
    protected void initWorld(World world) {
    }

    @Override
    protected void initSimulator(Simulator simulator) {
        simulator.setRenderer(this);
    }

    @Override
    public void render(World world) {
        // renderer renders into HtmlBuilder
        renderer.render(world);
        renderedHtml = renderer.getHtml();
        LOG.info("Game rendererd.");
    }

    public String getRenderedHtml() {
        if (renderedHtml == null) {
            return "";
        }
        return renderedHtml.toString();
    }
    
}