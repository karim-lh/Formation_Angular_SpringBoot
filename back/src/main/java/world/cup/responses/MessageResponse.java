package world.cup.responses;



public class MessageResponse {

	private boolean success;
	private String message;
	private String detail;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public MessageResponse(boolean success, String message, String detail) {
		this.success = success;
		this.message = message;
		this.detail = detail;
	}
}

