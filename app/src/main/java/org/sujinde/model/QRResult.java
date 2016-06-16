package org.sujinde.model;

/**
 * Created by Mr.SuJinde on 2016/6/16.
 */
public class QRResult {

	/**
	 * code : 200
	 */

	private MetadataEntity _metadata;
	/**
	 * _metadata : {"code":200}
	 * data : http://www.ibookey.com/gcb.html
	 */

	private String data;

	public MetadataEntity get_metadata() {
		return _metadata;
	}

	public void set_metadata(MetadataEntity _metadata) {
		this._metadata = _metadata;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static class MetadataEntity {
		private int code;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
	}
}
