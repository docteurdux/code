package dum.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DummyFile extends File {

	private static final long serialVersionUID = 1L;

	private boolean exists;
	private String name;

	public DummyFile(String pathname) {
		super(pathname);
		name = pathname;
	}

	@Override
	public boolean exists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean canExecute() {
		nsup();
		return exists;
	}

	@Override
	public boolean canRead() {
		nsup();
		return exists;
	}

	@Override
	public boolean canWrite() {
		nsup();
		return exists;
	}

	@Override
	public int compareTo(File pathname) {
		nsup();
		return 0;
	}

	@Override
	public boolean createNewFile() throws IOException {
		nsup();
		return false;
	}

	@Override
	public boolean delete() {
		nsup();
		return false;
	}

	@Override
	public void deleteOnExit() {
		nsup();
	}

	@Override
	public boolean equals(Object obj) {
		return obj == this;
	}

	@Override
	public File getAbsoluteFile() {
		nsup();
		return super.getAbsoluteFile();
	}

	@Override
	public String getAbsolutePath() {
		nsup();
		return super.getAbsolutePath();
	}

	@Override
	public File getCanonicalFile() throws IOException {
		nsup();
		return super.getCanonicalFile();
	}

	@Override
	public String getCanonicalPath() throws IOException {
		nsup();
		return super.getCanonicalPath();
	}

	@Override
	public long getFreeSpace() {
		nsup();
		return super.getFreeSpace();
	}

	@Override
	public String getParent() {
		nsup();
		return super.getParent();
	}

	@Override
	public File getParentFile() {
		nsup();
		return super.getParentFile();
	}

	@Override
	public String getPath() {
		nsup();
		return super.getPath();
	}

	@Override
	public long getTotalSpace() {
		nsup();
		return super.getTotalSpace();
	}

	@Override
	public long getUsableSpace() {
		nsup();
		return super.getUsableSpace();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean isAbsolute() {
		nsup();
		return super.isAbsolute();
	}

	@Override
	public boolean isDirectory() {
		nsup();
		return super.isDirectory();
	}

	@Override
	public boolean isFile() {
		nsup();
		return super.isFile();
	}

	@Override
	public boolean isHidden() {
		nsup();
		return super.isHidden();
	}

	@Override
	public long lastModified() {
		nsup();
		return super.lastModified();
	}

	private void len() {
		nsup();

	}

	@Override
	public File[] listFiles(FilenameFilter filter) {
		nsup();
		return super.listFiles(filter);
	}

	@Override
	public String[] list(FilenameFilter filter) {
		nsup();
		return super.list(filter);
	}

	@Override
	public boolean mkdir() {
		nsup();
		return super.mkdir();
	}

	@Override
	public boolean mkdirs() {
		nsup();
		return super.mkdirs();
	}

	@Override
	public boolean renameTo(File dest) {
		nsup();
		return super.renameTo(dest);
	}

	@Override
	public boolean setLastModified(long time) {
		nsup();
		return super.setLastModified(time);
	}

	@Override
	public boolean setReadOnly() {
		nsup();
		return super.setReadOnly();
	}

	@Override
	public boolean setExecutable(boolean executable) {
		nsup();
		return super.setExecutable(executable);
	}

	@Override
	public boolean setExecutable(boolean executable, boolean ownerOnly) {
		nsup();
		return super.setExecutable(executable, ownerOnly);
	}

	@Override
	public boolean setReadable(boolean readable) {
		nsup();
		return super.setReadable(readable);
	}

	@Override
	public boolean setReadable(boolean readable, boolean ownerOnly) {
		nsup();
		return super.setReadable(readable, ownerOnly);
	}

	@Override
	public boolean setWritable(boolean writable) {
		nsup();
		return super.setWritable(writable);
	}

	@Override
	public boolean setWritable(boolean writable, boolean ownerOnly) {
		nsup();
		return super.setWritable(writable, ownerOnly);
	}

	@Override
	public URL toURL() throws MalformedURLException {
		nsup();
		return super.toURL();
	}

	@Override
	public String toString() {
		nsup();
		return super.toString();
	}

	@Override
	public URI toURI() {
		nsup();
		return super.toURI();
	}

	private void nsup() {
		throw new RuntimeException("Not supported");
	}

}
