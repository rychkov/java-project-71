package hexlet.code;

public record DiffNode(
  String key,
  Status status,
  Object oldValue,
  Object newValue) {
}
