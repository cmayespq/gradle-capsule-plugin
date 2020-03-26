package us.kirchmeier.capsule.task

class FatCapsule extends Capsule {
  FatCapsule() {
    applicationSource = project.tasks.findByName('jar')
      def runtimeConfig = project.configurations.runtime
      getLogger().info("Runtime name: ${runtimeConfig.name}")
      getLogger().info("Runtime size: ${runtimeConfig.files.size()}")
      if (runtimeConfig.files.size() < 2) {
          getLogger().info("Need to find new config")
          embedConfiguration = project.configurations.default
      } else {
          getLogger().info("Using original runtime config")
          embedConfiguration = project.configurations.runtime
      }
  }
}
