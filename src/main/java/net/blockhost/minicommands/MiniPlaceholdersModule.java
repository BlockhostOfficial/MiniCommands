package net.blockhost.minicommands;

import io.github.miniplaceholders.api.MiniPlaceholders;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

public class MiniPlaceholdersModule {
    public static TagResolver getTagResolver() {
        return MiniPlaceholders.audienceGlobalPlaceholders();
    }
}
