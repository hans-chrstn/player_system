
{ pkgs ? import <nixpkgs> {} }:
let
  libs = with pkgs; [
    flite.lib
    alsa-lib
    libpulseaudio
    kotlin
    jetbrains.jdk
    glfw
    openal
    libGL
    glfw-wayland-minecraft
  ];
in
pkgs.mkShell {
  nativeBuildInputs = with pkgs; [
    jetbrains.idea-community
    aseprite
    blockbench
  ];

  buildInputs = libs;
  LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath libs;
  shellHook = ''
    alias ii='${pkgs.jetbrains.idea-community}/bin/idea-community'
    alias yy='yazi'
    alias aa='aseprite'
    alias bb='blockbench'


    echo "Type 'ii' to launch Intellij"
    echo "Type 'yy' to launch Yazi"
    echo "Type 'aa' to launch Aseprite"
    echo "Type 'bb' to launch Blockbench"
  '';
}
