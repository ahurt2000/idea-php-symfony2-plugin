package fr.adrienbrault.idea.symfony2plugin.external.toolbox.provider;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.psi.PsiElement;
import com.jetbrains.php.PhpIcons;
import de.espend.idea.php.toolbox.completion.dict.PhpToolboxCompletionContributorParameter;
import de.espend.idea.php.toolbox.extension.PhpToolboxProviderInterface;
import de.espend.idea.php.toolbox.navigation.dict.PhpToolboxDeclarationHandlerParameter;
import de.espend.idea.php.toolbox.provider.presentation.ProviderPresentation;
import fr.adrienbrault.idea.symfony2plugin.util.controller.ControllerIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Daniel Espendiller <daniel@espendiller.net>
 */
public class ControllerToolboxProvider implements PhpToolboxProviderInterface {
    @NotNull
    @Override
    public Collection<LookupElement> getLookupElements(@NotNull PhpToolboxCompletionContributorParameter parameter) {
        return ControllerIndex.getControllerLookupElements(parameter.getProject());
    }

    @NotNull
    @Override
    public Collection<PsiElement> getPsiTargets(final @NotNull PhpToolboxDeclarationHandlerParameter parameter) {
        return new ArrayList<PsiElement>() {{
            add(ControllerIndex.getControllerMethod(parameter.getProject(), parameter.getContents()));
        }};
    }

    @NotNull
    @Override
    public String getName() {
        return "symfony.controller";
    }

    @Nullable
    @Override
    public ProviderPresentation getPresentation() {
        return new ProviderPresentation() {
            @Nullable
            @Override
            public Icon getIcon() {
                return PhpIcons.METHOD_ICON;
            }

            @Nullable
            @Override
            public String getDescription() {
                return "Controller";
            }
        };
    }
}
