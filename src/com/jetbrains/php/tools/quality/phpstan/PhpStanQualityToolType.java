package com.jetbrains.php.tools.quality.phpstan;

import com.intellij.openapi.project.Project;
import com.jetbrains.php.tools.quality.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.jetbrains.php.tools.quality.phpstan.PhpStanConfigurationBaseManager.PHP_STAN;

public class PhpStanQualityToolType extends QualityToolType<PhpStanConfiguration> {
  @NotNull
  @Override
  public String getDisplayName() {
    return PHP_STAN;
  }

  @Override
  public @NotNull QualityToolBlackList getQualityToolBlackList(@NotNull Project project) {
    return PhpStanBlackList.getInstance(project);
  }

  @Override
  protected @NotNull QualityToolConfigurationManager<PhpStanConfiguration> getConfigurationManager(@NotNull Project project) {
    return PhpStanConfigurationManager.getInstance(project);
  }

  @Override
  protected @NotNull QualityToolValidationInspection getInspection() {
    return new PhpStanValidationInspection();
  }

  @Override
  protected @Nullable QualityToolConfigurationProvider<PhpStanConfiguration> getConfigurationProvider() {
    return PhpStanConfigurationProvider.getInstances();
  }

  @Override
  protected @NotNull QualityToolConfigurableForm<PhpStanConfiguration> createConfigurableForm(@NotNull Project project,
                                                                                              PhpStanConfiguration settings) {
    return new PhpStanConfigurableForm<>(project, settings);
  }

  @Override
  protected @NotNull QualityToolProjectConfiguration getProjectConfiguration(@NotNull Project project) {
    return PhpStanProjectConfiguration.getInstance(project);
  }

  @NotNull
  @Override
  protected PhpStanConfiguration createConfiguration(@NotNull Project project) {
    return new PhpStanConfiguration();
  }

  @Override
  public @Nullable String getHelpTopic() {
    return "reference.settings.php.PhpStan";
  }
}
