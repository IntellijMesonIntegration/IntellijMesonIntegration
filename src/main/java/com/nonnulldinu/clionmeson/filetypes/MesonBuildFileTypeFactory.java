package com.nonnulldinu.clionmeson.filetypes;

import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class MesonBuildFileTypeFactory extends FileTypeFactory {
	@Override
	public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
		fileTypeConsumer.consume(
				MesonBuildFileType.INSTANCE,
				new FileNameMatcherEx() {
					@Override
					@NotNull
					public String getPresentableString() {
						return "Meson Build File";
					}

					@Override
					public boolean acceptsCharSequence(CharSequence fileName) {
						return fileName.toString().matches("(meson[.]build)");
					}

				}
		);
	}
}


