attribute vec3 position;
attribute vec2 texCoord;
attribute vec3 normal;
attribute vec3 tangent;

varying vec2 texCoord0;
varying vec4 shadowMapCoords0;
varying mat3 tbnMatrix;
varying mat4 mvpMatrix;
varying vec3 worldPos0;
varying vec3 objectPos0;

uniform mat4 T_model;
uniform mat4 T_MVP;
uniform mat4 R_lightMatrix;

void main() {
	gl_Position = T_MVP * vec4(position, 1.0);
	texCoord0 = texCoord;
	mvpMatrix = T_MVP;
	shadowMapCoords0 = R_lightMatrix * vec4(position, 1.0);
	worldPos0 = (T_model * vec4(position, 1.0)).xyz;
    objectPos0 = position;

	vec3 n = normalize((T_model * vec4(normal, 0.0)).xyz);
	vec3 t = normalize((T_model * vec4(tangent, 0.0)).xyz);

    t = normalize(t - dot(t, n) * n);

	vec3 bitangent = cross(t, n);

    tbnMatrix = mat3(t, bitangent, n);
}
