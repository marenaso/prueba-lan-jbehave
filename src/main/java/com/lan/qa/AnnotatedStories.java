package com.lan.qa;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.web.selenium.*;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.WEB_DRIVER_HTML;

/**
 * Created with IntelliJ IDEA.
 * User: marenaso
 * Date: 08-10-13
 * Time: 03:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnnotatedStories extends InjectableEmbedder {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 120;

    public AnnotatedStories() {
    }

    @org.junit.Test
    public void run() {
        CrossReference crossReference = new CrossReference().withJsonOnly().withOutputAfterEachStory(true)
                .excludingStoriesWithNoExecutedScenarios(true);
        ContextView contextView = new LocalFrameContextView().sized(WIDTH, HEIGHT);
        SeleniumContext seleniumContext = new SeleniumContext();
        SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView, seleniumContext,
                crossReference.getStepMonitor());
        Format[] formats = new Format[]{new SeleniumContextOutput(seleniumContext), CONSOLE, WEB_DRIVER_HTML};
        StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
                .withCodeLocation(codeLocationFromClass(CompraNormalStories.class)).withFailureTrace(true)
                .withFailureTraceCompression(true).withDefaultFormats().withFormats(formats)
                .withCrossReference(crossReference);

        Configuration configuration = injectedEmbedder().configuration();
        configuration.useFailureStrategy(new FailingUponPendingStep())
                .useStoryControls(new StoryControls().doResetStateBeforeScenario(false)).useStepMonitor(stepMonitor)
                .useStoryLoader(new LoadFromClasspath(CompraNormalStories.class))
                .useStoryReporterBuilder(reporterBuilder);
        if (configuration instanceof SeleniumConfiguration) {
            SeleniumConfiguration seleniumConfiguration = (SeleniumConfiguration) configuration;
            seleniumConfiguration.useSeleniumContext(seleniumContext);
        }
        injectedEmbedder().runStoriesAsPaths(storyPaths());
    }

    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("**/" + System.getProperty("storyFilter", "*") + ".story"), null);
    }

}
