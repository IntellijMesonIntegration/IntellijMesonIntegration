package com.nonnulldinu.clionmeson.filetypes;

import com.intellij.openapi.fileTypes.FileNameMatcher;
import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class MesonBuildFileTypeFactory extends FileTypeFactory {
	@Override
	public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
		fileTypeConsumer.consume(
				MesonBuildFileType.INSTANCE,
				new FileNameMatcher() {
					@Override
					@NotNull
					public String getPresentableString() {
						return "Meson Build File";
					}

					@Override
					public boolean acceptsCharSequence(@NotNull CharSequence fileName) {
						return fileName.toString().equals("meson.build");

					}

				}
		);
	}
}


